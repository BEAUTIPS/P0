import flask
from flask import jsonify, request


app = flask.Flask(__name__)

#Testing repond JSON 
@app.route('/jsonresponses', methods=['GET', 'POST'])
def handle_request():
    response = {"message":"Successful Connection"}
    return jsonify(response)


#Testing respond String 
@app.route('/stringresponses', methods=['GET', 'POST'])
def handle_request_String():
    response = " Successfully connect with String response"
    return jsonify(response)


#Testing POST REQUEST
@app.route('/postrequests', methods=['GET', 'POST'])
def handle_post_request():
    content = request.json
    print(content)
    response = " Successfully get the post"
    return jsonify(response)


#Testing POST REQUEST
@app.route('/users', methods=['GET', 'POST'])
def handle_user_info():
    User = request.json
    print(User)
    response = "The user sending request is: " + User['name'] + ".His age is: " + str(User['age'])
    return jsonify(response)

# Closet
app.route('/closet', methods=['POST'])
def handle_closet_info():
    post = request.json
    print(post)


app.run(host="0.0.0.0", port=5000, debug=True)