from django.db import models

# Create your models here.
class User(models.Model):
	first_name = models.CharField(max_length=45)
	last_name = models.CharField(max_length=45)
	email = models.CharField(max_length=45)
	password = models.CharField(max_length=255)
	created_at = models.DateField(auto_now_add=True)
	updated_at = models.DateField(auto_now=True)

class Trips(models.Model):
	destination = models.CharField(max_length=45)
	start_date = models.DateField()
	end_date = models.DateField()
	plan = models.TextField()
	user = models.ForeignKey(User, related_name="trips")
	created_at = models.DateField(auto_now_add=True)
	updated_at = models.DateField(auto_now=True)

