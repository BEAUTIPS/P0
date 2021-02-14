
import flask
from flask import jsonify, request
from firebase_config_file import Firebase_auth
from firebase_admin import storage


app = flask.Flask(__name__)


#Login
email = "beautipstestuser@gmail.com"
password = "123456"
Firebase_instance = Firebase_auth()

# Firebase_instance.get_storage_bucket()
# Firebase_instance.initialize_firestore_retrieve_data("Abby")


#Testing POST REQUEST
@app.route('/stylistsinfos', methods=['GET', 'POST'])
def handle_post_request():
    content = request.json
    response = Firebase_instance.initialize_firestore_retrieve_data(request.json['name'])
    response['Availability'] = []
    return jsonify(response)

@app.route('/stylistsposts', methods=['GET', 'POST'])
def handle_stylist_post_request():
    content = request.json
    print("this is", content)
    response = Firebase_instance.retrieve_image(content)

    return jsonify(response)

@app.route('/login', methods= ['GET', 'POST'])
def handle_post_request_login():
    content = request.json
    email = content['email']
    password = content['password']
    if_signed_in = Firebase_instance.sign_in_with_email_and_password(email, password)
    print("Test login is successful!")
    return if_signed_in
  

@app.route('/signup', methods=['GET', 'POST'])
def handle_stylist_post_request_sign_up():
    content = request.json
    print(content)
    response = "Successfully Signup"
    return jsonify(response)


  
# @app.route('/UserInfo', methods=['GET', 'POST'])
# def handle_stylist_post_request_info():
#     #前端 --> User email

#     if Firebase_instance.sign_in_success = true:
#       # user_info = retrieve_user_login_info(user uuid)
#       #return user_info
#     else:
        # xxxxxx

app.run(host="0.0.0.0", port=5000, debug=True)
