# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-01-25 18:18
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0003_trips_users'),
    ]

    operations = [
        migrations.RenameField(
            model_name='trips',
            old_name='destrination',
            new_name='destination',
        ),
    ]
