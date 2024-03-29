from django.db import models

# Create your models here.
class Movie(models.Model):
	title = models.CharField(max_length=45)
	description = models.TextField()
	release_date = models.DateTimeField()
	actor = models.TextField()
	duration = models.IntegerField()
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)

	def __repr__(self):
		return f"Movie: {self.title} ({self.release_date})"