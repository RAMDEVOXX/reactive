import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EmployeeService } from 'src/app/service/employee.service';
import { Employee } from 'src/app/model/Employee';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DetailEmployeeComponent } from '../detail-employee/detail-employee.component';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';


@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  readonly CONTENU = "Êtes-vous sûr de vouloir supprimer cet employé ?";

  employees: Observable<Employee[]>;
  //@ViewChild('componentInsideModal') componentInsideModal: DetailEmployeeComponent;

  constructor(private employeeService: EmployeeService,
    private modalService: NgbModal,
    private router: Router) { }

  ngOnInit(): void {
    this.getListEmployees();
  }

  getListEmployees() {
    this.employees =this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe(
      data => {
        console.log(data);
        this.getListEmployees();
      },
      error => console.error("une erreur s'est produite lors de la suppression de l'employer"));
  }

  getDetailsEmployee(id: number){
    // this.router.navigate(['detail', id]);
  }

  openConfirmModal(employee: Employee) {
    const modalRef = this.modalService.open(ConfirmModalComponent);
    modalRef.componentInstance.titre ="Confirmer la suppression";
    modalRef.componentInstance.contenu = this.CONTENU;
    modalRef.componentInstance["confirmerEmitter"].subscribe(event => {
      console.log(event) ;
      // appel Service de suppression !
     });
  }

  /**
   * ajouterEmployee
   */
  public openModalAjout() {
    const modalRef = this.modalService.open(DetailEmployeeComponent);
    modalRef.componentInstance.employee = new Employee();
    modalRef.componentInstance["reloadListEmplyees"].subscribe(event => {
      console.log("here is the emitter !");
      this.getListEmployees();
     });
  }

}
