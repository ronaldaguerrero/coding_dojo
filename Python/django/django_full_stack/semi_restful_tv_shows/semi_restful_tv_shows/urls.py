### project url ###
from django.conf.urls import url, include	# added an import!
# from django.contrib import admin              # comment out, or just delete
urlpatterns = [
    url(r'^allshows/', include('apps.first_app.urls')),
    url(r'^edits/', include('apps.first_app.urls')),
    url(r'^show/', include('apps.first_app.urls')),
    url(r'^', include('apps.first_app.urls')),	# use your app_name here
]