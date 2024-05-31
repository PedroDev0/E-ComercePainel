import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'cmp-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  
  constructor(private rout: Router) {
  }
}
