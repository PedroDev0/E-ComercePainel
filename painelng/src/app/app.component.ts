import { PT_BR } from './core/langs/pt-br';
import { Component, OnInit } from '@angular/core';
import { PrimeNGConfig } from 'primeng/api';

@Component({
  selector: 'app-root',
  template: `<cmp-template></cmp-template>
      `
})
export class AppComponent implements OnInit {
  title = 'painelng';
  
  constructor(private config:PrimeNGConfig){

  }
  ngOnInit(): void {
    this.config.setTranslation(PT_BR);
  }
}
