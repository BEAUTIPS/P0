
import flask
from flask import jsonify, request
from firebase_config_file import Firebase_auth

app = flask.Flask(__name__)


#Login
email = "beautipstestuser@gmail.com"
password = "123456"
Firebase_instance = Firebase_auth()
Firebase_instance.sign_in_with_email_and_password(email, password)
# Firebase_instance.get_storage_bucket()
# Firebase_instance.initialize_firestore_retrieve_data("Abby")


#Testing POST REQUEST
@app.route('/stylistsinfos', methods=['GET', 'POST'])
def handle_post_request():
    #content = request.json
    print(request.json)
    response = Firebase_instance.initialize_firestore_retrieve_data(request.json['name'])
    response['Availability'] = []
    print(response)

    return jsonify(response)


app.run(host="0.0.0.0", port=5000, debug=True)
