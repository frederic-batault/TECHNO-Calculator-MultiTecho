import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms'; // <-- NgModel lives here
import {AppComponent} from './app.component';
import {CalcComponent} from './calc/calc.component';
import {HttpClientModule} from '@angular/common/http';
import { MemoireComponent } from './memoire/memoire.component'; // pour webservice

@NgModule({
  declarations: [
    AppComponent,
    CalcComponent,
    MemoireComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
