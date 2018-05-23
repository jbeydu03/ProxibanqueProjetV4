import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OperationsService } from '../operations.service';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styles: []
})
export class AuditComponent implements OnInit {
  auditForm: FormGroup;
  compteAll : Compte[];
  constructor(private fb: FormBuilder, private route: ActivatedRoute, private router: Router, private operationService: OperationsService )  { }

  ngOnInit() {
    this.auditForm = this.fb.group({
      montant: [''], 
    });
    
    
  }
  

  lancerForm(){
    this.operationService.loadAllCompte().subscribe(compte => this.compteAll = compte);
  }

  submitClass(compte : Compte, montant = 1000) {
    montant = this.auditForm.get('montant').value;
    return  compte.solde >montant ? 'succes' : 'error';
  }
}
