import { Injectable } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';

@Injectable({
  providedIn: 'root',
})
export class UtilService {

  private readonly toast = 'toast';
  private readonly confirm = 'confirm';
  constructor(private dialogService: DialogService, private messageService: MessageService, private confirmDialogService: ConfirmationService) { }

  showDialog(dialog: any, config: any): DynamicDialogRef {
    return this.dialogService.open(dialog, config);
  }
  showConfirmDialog(message: string, title: string):Promise<Boolean> {
    return new Promise((resolve) => {
      this.confirmDialogService.confirm({
        message: message,
        header: title,
        key: this.confirm,
        icon: 'pi pi-exclamation-triangle',
        accept: () => resolve(true),
        reject: () => resolve(false),
      });
    });
  }

  showWarn(mensagem: string) {
    this.messageService.add({ key: this.toast, severity: 'warn', summary: 'Atenção', detail: mensagem });
  }
  showInfo(mensagem: string) {
    this.messageService.add({ key: this.toast, severity: 'info', summary: 'Info', detail: mensagem });
  }

}
