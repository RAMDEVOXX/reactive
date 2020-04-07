import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Employee } from 'src/app/model/Employee';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-detail-employee',
  templateUrl: './detail-employee.component.html',
  styleUrls: ['./detail-employee.component.css']
})
export class DetailEmployeeComponent implements OnInit {

  employee: Employee;
  createEmployeeForm: FormGroup;

  constructor(public activeModal: NgbActiveModal,
    private modalService: NgbModal,
    private formBuilder: FormBuilder) {

    this.createEmployeeForm = this.formBuilder.group({
      lastName: ['']
    });
  }

@Output() reloadListEmplyees = new EventEmitter<any>();

  ngOnInit(): void {}

  /**
   * ajouterEmployee
   */
  public ajouterEmployee() {
    //service Create employe
    this.employee = new Employee(this.createEmployeeForm.value);
    this.activeModal.close(this.createEmployeeForm.value);
    this.reloadListEmplyees.emit();
  }
}
