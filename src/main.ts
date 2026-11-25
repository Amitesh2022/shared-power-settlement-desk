import {bootstrapApplication} from '@angular/platform-browser'
import {ChangeDetectionStrategy, Component, computed, inject, DestroyRef, signal, provideZonelessChangeDetection} from '@angular/core'
import {Desk,select,categories,stages,value,formatDate,type State} from './desk'
const count=(state:State)=>Object.fromEntries(stages.map(stage=>[stage,state.records.filter(r=>r.stage===stage).length]))
@Component({selector:'desk-app',templateUrl:'./desk.html',changeDetection:ChangeDetectionStrategy.OnPush})
class App {
 desk=new Desk()
 s=signal(this.desk.state)
 categories=categories
 stages=stages
 value=value
 formatDate=formatDate
 visible=computed(()=>{const s=this.s();return select(s.records,s.query,s.filter,s.sort)})
 totals=computed(()=>count(this.s()))
 constructor(){const off=this.desk.subscribe(s=>this.s.set(s));const stop=this.desk.start();inject(DestroyRef).onDestroy(()=>{off();stop()})}
}
bootstrapApplication(App,{providers:[provideZonelessChangeDetection()]}).catch(console.error)
