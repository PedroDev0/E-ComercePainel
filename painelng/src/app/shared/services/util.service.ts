import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Injectable } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';

@Injectable({
  providedIn: 'root',
})
export class UtilService {

  constructor(private dialogService: DialogService, private messageService: MessageService, private confirmDialogService: ConfirmationService) { }

  showDialog(dialog: any, config: any): DynamicDialogRef {
    return this.dialogService.open(dialog, config);
  }
  showConfirmDialog(message: string, title: string): ConfirmationService {
    return this.confirmDialogService.confirm({
      message: message,
      header: title,
      icon: 'pi pi-exclamation-triangle',
    });
  }

  showWarn(mensagem: string, key: string) {
    this.messageService.add({ key: key, severity: 'warn', summary: 'Atenção', detail: mensagem });
  }
  showInfo(mensagem: string, key: string) {
    this.messageService.add({ key: key, severity: 'info', summary: 'Info', detail: mensagem });
  }

}
