### url in projects folder ###
from django.conf.urls import url, include
urlpatterns = [
    url(r'^', include('apps.first_app.urls')),
    url(r'^random/', include('apps.first_app.urls')),
    url(r'^generate/', include('apps.first_app.urls')),
    url(r'^reset/', include('apps.first_app.urls')),
]