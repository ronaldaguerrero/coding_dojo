from django.db import models
from datetime import datetime as dt

# Create your models here.
class ShowManager(models.Manager):
	def validator(self, postData):
		d = dt.strptime(postData['rel_date'], "%Y-%m-%d")
		today = dt.now()
		errors = {}
		if len(postData['title']) < 2:
			errors["title"] = "Title should be at least 2 characters"
		if len(postData['net']) < 3:
			errors["network"] = "Network should be at least 3 characters"
		if len(postData['desc']) < 10:
			if len(postData['desc']) < 1:
				pass
			elif len(postData['desc']) < 10:
				errors["description"] = "Descrption should be at least 10 characters"
		if d > today:
			errors["release_date"] = 'Release date should be in the past'
		title = Show.objects.filter(title=postData['title'])
		if len(title) > 0:
			errors['title'] = 'Title is taken'
		return errors

class Show(models.Model):
	title = models.CharField(max_length=255)
	network = models.CharField(max_length=255)
	release_date = models.DateField()
	description = models.TextField()
	created_at = models.DateTimeField(auto_now=True)
	updated_at = models.DateTimeField(auto_now_add=True)
	objects = ShowManager()
