# import requests

# # Define the URL for the Flask app
# url = 'http://127.0.0.1:5000/api/predict'

# # Define the feature values
# data = {
#     "battery_power": 1725,     # Example battery power
#     "blue": 1,                 # Bluetooth presence (0 or 1)
#     "clock_speed": 1.6,       # Clock speed
#     "dual_sim": 1,             # Dual SIM presence (0 or 1)
#     "fc": 6,                   # Front camera
#     "four_g": 1,              # 4G presence (0 or 1)
#     "int_memory": 6,          # Internal memory
#     "m_dep": 0.5,              # Mobile depth
#     "mobile_wt": 119,         # Mobile weight
#     "n_cores": 2,             # Number of cores
#     "pc": 18,                  # Primary camera
#     "px_height": 609,          # Pixel height
#     "px_width": 1307,          # Pixel width
#     "ram": 1500,              # RAM
#     "sc_h": 6,                # Screen height
#     "sc_w": 5,                # Screen width
#     "talk_time": 4,          # Talk time
#     "three_g": 0,             # 3G presence (0 or 1)
#     "touch_screen": 1,        # Touch screen presence (0 or 1)
#     "wifi": 0,            # WiFi presence (0 or 1)
# }

# # Send the POST request to the Flask app
# response = requests.post(url, json=data)

# if response.status_code == 200:
#     print("Predictions:", response.json())
# else:
#     print("Error:", response.text)


import requests

# Define the URL for the Flask app
url = 'http://127.0.0.1:5000/api/predict'

# Define the feature values
data = {
    "battery_power": 1021,   
    "blue": 1,                 
    "clock_speed": 0.5,       
    "dual_sim": 1,        
    "fc": 0,            
    "four_g": 1,             
    "int_memory": 53,          
    "m_dep": 0.7,         
    "mobile_wt": 136,         
    "n_cores": 3,          
    "pc": 6,               
    "px_height": 905,    
    "px_width": 1988,         
    "ram": 2631,            
    "sc_h": 17,           
    "sc_w": 3,           
    "talk_time": 7,    
    "three_g": 1,           
    "touch_screen": 1,       
    "wifi": 0,            
}
data2={'battery_power': 0, 'blue':0, 'clock_speed': 0.5, 'dual_sim': 0, 'fc': 0, 'four_g': 0, 'int_memory': 3, 'm_dep': 0.7, 'mobile_wt': 136, 'n_cores': 1, 'pc': 2, 'px_height': 90, 'px_width': 198, 'ram': 2100, 'sc_h': 17, 'sc_w': 3, 'talk_time': 7, 'three_g': 1, 'touch_screen': 1, 'wifi': 0}
# Send the POST request to the Flask app
try:
    response = requests.post(url, json=data2)

    if response.status_code == 200:
        
        print("Predictions:", response.json())
    else:
        print("Error:", response.text)
except Exception as e:
    print("An error occurred:", str(e))

