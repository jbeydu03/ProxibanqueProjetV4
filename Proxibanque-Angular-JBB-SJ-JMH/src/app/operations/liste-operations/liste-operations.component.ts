import { Component, OnInit, Input } from '@angular/core';
import { Operation } from '../../model/operation';
import { operations } from '../../model/operations';

@Component({
  selector: 'app-liste-operations',
  templateUrl: './liste-operations.component.html',
  styles: []
})
export class ListeOperationsComponent implements OnInit {

  operationsList = operations;
  
  constructor() { }

  ngOnInit() {

  }

}
