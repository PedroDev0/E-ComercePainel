import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';

@Injectable({
  providedIn: 'root',
})
export class UtilService {

  constructor(private dialogService: DialogService, private messageService: MessageService ) { }

  showDialog(dialog: any, config: any): DynamicDialogRef {
    return this.dialogService.open(dialog, config);
  }

  showMensagem(mensagem:string): void {
     this.messageService.add({ severity: 'info', summary: 'info', detail: mensagem });
  }
}
