### app url, any changes here will need to exist in views ##
from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
]