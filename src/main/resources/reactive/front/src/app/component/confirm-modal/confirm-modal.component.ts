import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-confirm-modal',
  templateUrl: './confirm-modal.component.html',
  styleUrls: ['./confirm-modal.component.css']
})
export class ConfirmModalComponent implements OnInit {

  @Input() titre: string;
  @Input() contenu: string;
  @Output() confirmerEmitter = new EventEmitter<any>();

  constructor(public activeModal: NgbActiveModal,
    private modalService: NgbModal) { }

  ngOnInit(): void {}

  /**
   * confirmer
   */
  public confirmer() {
    this.confirmerEmitter.emit();
  }

}
