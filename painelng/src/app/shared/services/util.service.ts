import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';

@Injectable({
  providedIn: 'root',
})
export class UtilService {

  constructor(private dialogService: DialogService, public messageService: MessageService ) { }

  showDialog(dialog: any, config: any): DynamicDialogRef {
    return this.dialogService.open(dialog, config);
  }

  showWarn(mensagem:string,key:string) {
    this.messageService.add({ key: key, severity: 'warn', summary: 'Atenção',detail: mensagem });
  }
  showInfo(mensagem:string,key:string) {
    this.messageService.add({ key: key, severity: 'info', summary: 'Opa',detail: mensagem });
  }

}
