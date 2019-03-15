from django.db import models

# Create the CarManager class
class CarManager(models.Manager):
    def validate_car(self, postData):
        errors = {}
        # Make sure the car name is at least 4 characters long
        if len(postData['name'])<4:
            errors['name'] = "Name must be at least 4 characters long"
        # Make sure the year is before 2019
        if int(postData['year']) > 2019:
            errors['year'] = "Car must be made before 2019"
        return errors


# Create your models here.
class Car(models.Model):
    name = models.CharField(max_length=45)
    year = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = CarManager() # This is new if you are using ModelManager to validate

class User(models.Model):
    first_name=models.CharField(max_length=45)
    last_name=models.CharField(max_length=45)
    email=models.CharField(max_length=45)
    password=models.CharField(max_length=255)
