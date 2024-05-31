import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UtilService {

  constructor(public dialogService: DialogService) { }

  showDialog(dialog: any, config: any): DynamicDialogRef {
    return this.dialogService.open(dialog, config);
  }
}
