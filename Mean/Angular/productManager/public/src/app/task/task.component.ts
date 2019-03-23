import { HttpService } from "../http.service";
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
	
  @Input() taskToShow: any;


  constructor(private _httpService: HttpService) { }

  ngOnInit() {
  }

}