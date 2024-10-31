##
##
from flask import Flask, request, jsonify
import pandas as pd
import pickle

app = Flask(__name__)

# Load model and imputer
try:
    with open("rf_model.pkl", "rb") as file:
        rf_model = pickle.load(file)
    print("Model loaded successfully.")
except Exception as e:
    print(f"An error occurred loading the model: {e}")

try:
    with open("imputer.pkl", "rb") as file:
        imputer = pickle.load(file)
    print("Imputer loaded successfully.")
except Exception as e:
    print(f"An error occurred loading the imputer: {e}")

# Define the expected feature names and order
required_features = ['battery_power', 'blue', 'clock_speed', 'dual_sim', 'fc',
                     'four_g', 'int_memory', 'm_dep', 'mobile_wt', 'n_cores',
                     'pc', 'px_height', 'px_width', 'ram', 'sc_h', 'sc_w',
                     'talk_time', 'three_g', 'touch_screen', 'wifi']

@app.route('/api/predict', methods=['POST'])
def predict_price():
    print("Received a request for prediction.")
    specs = request.json
    print(f"Specs received: {specs}")

    # Convert specs to DataFrame and reorder columns
    specs_df = pd.DataFrame([specs])
    
    # Ensure correct column order
    specs_df = specs_df.reindex(columns=required_features)
    
    # Log the DataFrame before imputation
    print("DataFrame before imputation:", specs_df)

    try:
        # Impute missing values and log the imputed data
        specs_df_imputed = pd.DataFrame(imputer.transform(specs_df), columns=specs_df.columns)
        print("Data after imputation:", specs_df_imputed)
    except ValueError as e:
        print(f"Error during imputation: {e}")
        return jsonify({"error": "Feature mismatch between input data and imputer expectations."}), 500

    # Convert the imputed DataFrame back to JSON for verification
    imputed_data_json = specs_df_imputed.to_dict(orient="records")[0]
    print(f"Imputed data sent for prediction: {imputed_data_json}")

    # Make prediction
    predicted_price_range = rf_model.predict(specs_df_imputed.values)
    print(predicted_price_range)

    # Return both the prediction and the imputed data in JSON response
    return jsonify({
        "predicted_price_range": int(predicted_price_range[0]),
        "imputed_data": imputed_data_json
    }), 200

if __name__ == "__main__":
    app.run(debug=True)
