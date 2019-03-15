### url in projects folder for urls###
from django.conf.urls import url, include
urlpatterns = [
    url(r'^', include('apps.first_app.urls')),
    url(r'^reset/', include('apps.first_app.urls')),
    url(r'^process_money/',include('apps.first_app.urls')),
]