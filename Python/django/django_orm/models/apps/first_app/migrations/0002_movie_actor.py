# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-01-19 21:48
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('first_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='movie',
            name='actor',
            field=models.TextField(default='an actor'),
            preserve_default=False,
        ),
    ]
