(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0d3be0e2"],{"0dd2":function(t,e,a){},"1a9a":function(t,e,a){"use strict";var n=a("0dd2"),o=a.n(n);o.a},3123:function(t,e,a){"use strict";a.d(e,"b",(function(){return o})),a.d(e,"a",(function(){return i}));var n=a("b775");function o(){return Object(n["a"])({url:"/photo/qiniu/getToken",method:"get"})}function i(){return Object(n["a"])({url:"/photo/qiniu/getAllphotos",method:"get"})}},"778f":function(t,e,a){},"816b":function(t,e,a){"use strict";var n=a("852a"),o=a.n(n);o.a},"852a":function(t,e,a){},9393:function(t,e,a){"use strict";var n=a("778f"),o=a.n(n);o.a},9406:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"dashboard-container"},[a("h2",{attrs:{align:"center"}},[t._v("Hello Aamir")]),t._v(" "),a("panel-group",{on:{handleSetLineChartData:t.handleSetLineChartData}}),t._v(" "),a("el-row",{staticStyle:{"margin-top":"30px",background:"#fff",padding:"15px 15px 0"}},[a("line-chart",{attrs:{"chart-data":t.lineChartData}})],1),t._v(" "),a("el-upload",{attrs:{action:"https://upload.qbox.me",data:t.dataObj,drag:"",multiple:!0,"before-upload":t.beforeUpload,"on-success":t.uploadSuccess}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])])]),t._v(" "),a("todo-list",{staticStyle:{margin:"0 8px"}})],1)},o=[],i=(a("5ab2"),a("6d57"),a("e10e"),a("cc57"),a("ac9f")),s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("section",{staticClass:"todoapp"},[a("header",{staticClass:"header"},[a("input",{staticClass:"new-todo",attrs:{autocomplete:"off",placeholder:"Todo List"},on:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.addTodo(e)}}})]),t._v(" "),a("section",{directives:[{name:"show",rawName:"v-show",value:t.todos.length,expression:"todos.length"}],staticClass:"main"},[a("input",{staticClass:"toggle-all",attrs:{id:"toggle-all",type:"checkbox"},domProps:{checked:t.allChecked},on:{change:function(e){return t.toggleAll({done:!t.allChecked})}}}),t._v(" "),a("label",{attrs:{for:"toggle-all"}}),t._v(" "),a("ul",{staticClass:"todo-list"},t._l(t.filteredTodos,(function(e,n){return a("todo",{key:n,attrs:{todo:e},on:{toggleTodo:t.toggleTodo,editTodo:t.editTodo,deleteTodo:t.deleteTodo}})})),1)]),t._v(" "),a("footer",{directives:[{name:"show",rawName:"v-show",value:t.todos.length,expression:"todos.length"}],staticClass:"footer"},[a("span",{staticClass:"todo-count"},[a("strong",[t._v(t._s(t.remaining))]),t._v("\n      "+t._s(t._f("pluralize")(t.remaining,"item"))+" left\n    ")]),t._v(" "),a("ul",{staticClass:"filters"},t._l(t.filters,(function(e,n){return a("li",{key:n},[a("a",{class:{selected:t.visibility===n},on:{click:function(e){e.preventDefault(),t.visibility=n}}},[t._v(t._s(t._f("capitalize")(n)))])])})),0)])])},r=[],c=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("li",{staticClass:"todo",class:{completed:t.todo.done,editing:t.editing}},[a("div",{staticClass:"view"},[a("input",{staticClass:"toggle",attrs:{type:"checkbox"},domProps:{checked:t.todo.done},on:{change:function(e){return t.toggleTodo(t.todo)}}}),t._v(" "),a("label",{domProps:{textContent:t._s(t.todo.text)},on:{dblclick:function(e){t.editing=!0}}}),t._v(" "),a("button",{staticClass:"destroy",on:{click:function(e){return t.deleteTodo(t.todo)}}})]),t._v(" "),a("input",{directives:[{name:"show",rawName:"v-show",value:t.editing,expression:"editing"},{name:"focus",rawName:"v-focus",value:t.editing,expression:"editing"}],staticClass:"edit",domProps:{value:t.todo.text},on:{keyup:[function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.doneEdit(e)},function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"esc",27,e.key,["Esc","Escape"])?null:t.cancelEdit(e)}],blur:t.doneEdit}})])},l=[],d={name:"Todo",props:["todo"],data:function(){return{editing:!1}},directives:{focus:function(t,e,a){var n=e.value,o=a.context;n&&o.$nextTick((function(){t.focus()}))}},methods:{deleteTodo:function(t){this.$emit("deleteTodo",t)},editTodo:function(t){var e=t.todo,a=t.value;this.$emit("editTodo",{todo:e,value:a})},toggleTodo:function(t){this.$emit("toggleTodo",t)},doneEdit:function(t){var e=t.target.value.trim(),a=this.todo;e?this.editing&&(this.editTodo({todo:a,value:e}),this.editing=!1):this.deleteTodo({todo:a})},cancelEdit:function(t){t.target.value=this.todo.text,this.editing=!1}}},u=d,p=a("623f"),h=Object(p["a"])(u,c,l,!1,null,null,null),f=h.exports,v="todos",g={all:function(t){return t},active:function(t){return t.filter((function(t){return!t.done}))},completed:function(t){return t.filter((function(t){return t.done}))}},m=[{text:"star this repository",done:!1},{text:"fork this repository",done:!1},{text:"follow author",done:!1},{text:"vue-element-admin",done:!0},{text:"vue",done:!0},{text:"element-ui",done:!0},{text:"axios",done:!0},{text:"webpack",done:!0}],C={components:{Todo:f},data:function(){return{visibility:"all",filters:g,todos:m}},computed:{allChecked:function(){return this.todos.every((function(t){return t.done}))},filteredTodos:function(){return g[this.visibility](this.todos)},remaining:function(){return this.todos.filter((function(t){return!t.done})).length}},methods:{setLocalStorgae:function(){window.localStorage.setItem(v,JSON.stringify(this.todos))},addTodo:function(t){var e=t.target.value;e.trim()&&(this.todos.push({text:e,done:!1}),this.setLocalStorgae()),t.target.value=""},toggleTodo:function(t){t.done=!t.done,this.setLocalStorgae()},deleteTodo:function(t){this.todos.splice(this.todos.indexOf(t),1),this.setLocalStorgae()},editTodo:function(t){var e=t.todo,a=t.value;e.text=a,this.setLocalStorgae()},clearCompleted:function(){this.todos=this.todos.filter((function(t){return!t.done})),this.setLocalStorgae()},toggleAll:function(t){var e=this,a=t.done;this.todos.forEach((function(t){t.done=a,e.setLocalStorgae()}))}},filters:{pluralize:function(t,e){return 1===t?e:e+"s"},capitalize:function(t){return t.charAt(0).toUpperCase()+t.slice(1)}}},_=C,b=(a("1a9a"),Object(p["a"])(_,s,r,!1,null,null,null)),y=b.exports,x=a("52c1"),w=a("3123"),k=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("el-row",{staticClass:"panel-group",attrs:{gutter:20}},[a("el-col",{attrs:{span:4}},[a("div",{staticClass:"card-panel",on:{click:function(e){return t.handleSetLineChartData("newVisitis")}}},[a("div",{staticClass:"card-panel-icon-wrapper icon-people"},[a("svg-icon",{attrs:{"icon-class":"peoples","class-name":"card-panel-icon"}})],1),t._v(" "),a("div",{staticClass:"card-panel-description"},[a("div",{staticClass:"card-panel-text"},[t._v("New Visits")]),t._v(" "),a("count-to",{staticClass:"card-panel-num",attrs:{startVal:0,endVal:102400,duration:3600}})],1)])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"card-panel",on:{click:function(e){return t.handleSetLineChartData("messages")}}},[a("div",{staticClass:"card-panel-icon-wrapper icon-message"},[a("svg-icon",{attrs:{"icon-class":"message","class-name":"card-panel-icon"}})],1),t._v(" "),a("div",{staticClass:"card-panel-description"},[a("div",{staticClass:"card-panel-text"},[t._v("Posts")]),t._v(" "),a("count-to",{staticClass:"card-panel-num",attrs:{startVal:0,endVal:81212,duration:4e3}})],1)])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"card-panel",on:{click:function(e){return t.handleSetLineChartData("purchases")}}},[a("div",{staticClass:"card-panel-icon-wrapper icon-money"},[a("svg-icon",{attrs:{"icon-class":"money","class-name":"card-panel-icon"}})],1),t._v(" "),a("div",{staticClass:"card-panel-description"},[a("div",{staticClass:"card-panel-text"},[t._v("Tags")]),t._v(" "),a("count-to",{staticClass:"card-panel-num",attrs:{startVal:0,endVal:9280,duration:4e3}})],1)])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"card-panel",on:{click:function(e){return t.handleSetLineChartData("shoppings")}}},[a("div",{staticClass:"card-panel-icon-wrapper icon-shoppingCard"},[a("svg-icon",{attrs:{"icon-class":"shoppingCard","class-name":"card-panel-icon"}})],1),t._v(" "),a("div",{staticClass:"card-panel-description"},[a("div",{staticClass:"card-panel-text"},[t._v("Categories")]),t._v(" "),a("count-to",{staticClass:"card-panel-num",attrs:{startVal:0,endVal:13600,duration:4600}})],1)])]),t._v(" "),a("el-col",{attrs:{span:4}},[a("div",{staticClass:"card-panel",on:{click:function(e){return t.handleSetLineChartData("shoppings")}}},[a("div",{staticClass:"card-panel-icon-wrapper icon-shoppingCard"},[a("svg-icon",{attrs:{"icon-class":"shoppingCard","class-name":"card-panel-icon"}})],1),t._v(" "),a("div",{staticClass:"card-panel-description"},[a("div",{staticClass:"card-panel-text"},[t._v("Notifications")]),t._v(" "),a("count-to",{staticClass:"card-panel-num",attrs:{startVal:0,endVal:13600,duration:4600}})],1)])])],1)},O=[],D=a("39ac"),S=a.n(D),T={components:{CountTo:S.a},methods:{handleSetLineChartData:function(t){this.$emit("handleSetLineChartData",t)}}},j=T,L=(a("9393"),Object(p["a"])(j,k,O,!1,null,"54ca4f20",null)),E=L.exports,P=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{class:t.className,style:{height:t.height,width:t.width}})},z=[],V=a("6e64"),N=a.n(V),$=a("ed08");a("ded5");var A={props:{className:{type:String,default:"chart"},width:{type:String,default:"100%"},height:{type:String,default:"350px"},autoResize:{type:Boolean,default:!0},chartData:{type:Object}},data:function(){return{chart:null}},mounted:function(){var t=this;this.initChart(),this.autoResize&&(this.__resizeHanlder=Object($["a"])((function(){t.chart&&t.chart.resize()}),100),window.addEventListener("resize",this.__resizeHanlder));var e=document.getElementsByClassName("sidebar-container")[0];e.addEventListener("transitionend",this.__resizeHanlder)},beforeDestroy:function(){if(this.chart){this.autoResize&&window.removeEventListener("resize",this.__resizeHanlder);var t=document.getElementsByClassName("sidebar-container")[0];t.removeEventListener("transitionend",this.__resizeHanlder),this.chart.dispose(),this.chart=null}},watch:{chartData:{deep:!0,handler:function(t){this.setOptions(t)}}},methods:{setOptions:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=t.expectedData,a=t.actualData;this.chart.setOption({xAxis:{data:["Mon","Tue","Wed","Thu","Fri","Sat","Sun"],boundaryGap:!1,axisTick:{show:!1}},grid:{left:10,right:10,bottom:20,top:30,containLabel:!0},tooltip:{trigger:"axis",axisPointer:{type:"cross"},padding:[5,10]},yAxis:{axisTick:{show:!1}},legend:{data:["expected","actual"]},series:[{name:"expected",itemStyle:{normal:{color:"#FF005A",lineStyle:{color:"#FF005A",width:2}}},smooth:!0,type:"line",data:e,animationDuration:2800,animationEasing:"cubicInOut"},{name:"actual",smooth:!0,type:"line",itemStyle:{normal:{color:"#3888fa",lineStyle:{color:"#3888fa",width:2},areaStyle:{color:"#f3f8ff"}}},data:a,animationDuration:2800,animationEasing:"quadraticOut"}]})},initChart:function(){this.chart=N.a.init(this.$el,"macarons"),this.setOptions(this.chartData)}}},H=A,F=Object(p["a"])(H,P,z,!1,null,null,null),q=F.exports;function B(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,n)}return a}function J(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?B(Object(a),!0).forEach((function(e){Object(i["a"])(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):B(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}var R={newVisitis:{expectedData:[100,120,161,134,105,160,165],actualData:[120,82,91,154,162,140,145]},messages:{expectedData:[200,192,120,144,160,130,140],actualData:[180,160,151,106,145,150,130]},purchases:{expectedData:[80,100,121,104,105,90,100],actualData:[120,90,100,138,142,130,130]},shoppings:{expectedData:[130,140,141,142,145,150,160],actualData:[120,82,91,154,162,140,130]}},U={name:"Dashboard",computed:J({},Object(x["b"])(["name"])),components:{TodoList:y,PanelGroup:E,LineChart:q},data:function(){return{currentDate:new Date,dataObj:{token:"",key:""},image_uri:[],fileList:[],lineChartData:R.newVisitis}},methods:{handleSetLineChartData:function(t){this.lineChartData=R[t]},beforeUpload:function(t){var e=this;return new Promise((function(t,a){Object(w["b"])().then((function(a){console.log(a.data.data);var n=a.data.data.key,o=a.data.data.token;e.dataObj.token=o,e.dataObj.key=n,t(!0)})).catch((function(t){console.log(t),a(!1)}))}))},uploadSuccess:function(t,e,a){console.log("1++++++++++++++++++++++++++++++++="),console.log(t),console.log("2++++++++++++++++++++++++++++++++="),console.log(e.name),console.log("3++++++++++++++++++++++++++++++++="),console.log(a)}}},G=U,I=(a("816b"),Object(p["a"])(G,n,o,!1,null,"67a6d9d8",null));e["default"]=I.exports}}]);