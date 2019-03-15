import bcrypt
import re

# html file
#make a href that triggers url
add to html file
{% if messages %}
<ul class="messages">
    {% for message in messages %}
    <li{% if message.tags %} class="{{ message.tags }}"{% endif %}>{{ message }}</li>
    {% endfor %}
</ul>
{% endif %}

#	create form
		<form action="/users" method="POST">
			<p>First name: <input type="text" name="first_name"></p>
			<p>Last name: <input type="text" name="last_name"></p>
			<p>Email: <input type="email" name="email"></p>
			<p>Password: <input type="password" name="password"></p>
			<p>Confirm Password: <input type="password" name="confirm_password"></p>
			<button> submit </button>
		</form>

			add register function



# urls .py
add urls and link to function



# views.py

add regex code somwhere *****

def register_form(request):
	return render (request, ...html file)

def register_user(request):
	# 1. Validate the form inputs
	errors = {}
	if len(request.POST['first_name'])<2:
		errors['first_name'] = 'First name must be at least two characters long'
	if request.post['first_name'].isalpha() == False:
		errors['first_name'] = 'First name must have only letters'
	if len(request.POST['last_name'])<2:
		errors['last_name'] = 'Last name must be at least two characters long'
	if request.post['last_name'].isalpha() == False:
		errors['last_name'] = 'Last name must have only letters'
	users_with_email = User.objects.filter(email=request.POST['email'])
	if len(users_with_email) > 0:
		errors['email'] = 'Email is taken'
	if not EMAIL_REGEX.match(request.POST['email']):
		errors['email'] = 'Email is invalid format.'
	if len(request.POST['password']) < 8:
		errors['password'] = 'Password must be at least 8 characters long'
	if request.POST['password'] != request.POST['confirm_password']:
		errors['password'] = 'Password must match'
	if len(errors) != 0:
		for key, value in errors.items():
			messages.error(request,value)
		return redirect('/register')
	# 2. If valid, hash the pw w/ bcript
	else:
		hash1 = bcrypt.hashpw(request.POST['password'].encode(), bcrypt.gensalt())
	# 3. Run the query to add the user to the db
		User.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'],password=hash1)
		print('*'*50)
		print('created a new user', new_user.__dict__)
		return redirect('/')


# models.py

create new model for User

class User(models.Model):
	first_name=models.CharField(max_length=45)
	last_name=models.CharField(max_length=45)
	email=models.CharField(max_length=45)
	password=models.CharField(max_length=255)

after: 
	-make migrations 
	-then migrate

login pseduo code
	#1 query db for a user w/ email address entered
		users_with_email = User.objects.filter(email=request.POST['email'])
	#2 if the user exists use the bcrypt.checkpw function to check the hashed pw
		
	#3 if the function returns true then add the users id to request.session
	#4 redirect

