(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b7c4a2f8"],{"0031":function(e,t,a){"use strict";var n=a("67c0"),s=a.n(n);s.a},"67c0":function(e,t,a){},"97fb":function(e,t,a){"use strict";var n=a("d432"),s=a.n(n);s.a},d432:function(e,t,a){},ee3d:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"login-container"},[a("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.ResetParam,"auto-complete":"on","label-position":"left"}},[a("div",{staticClass:"title-container"},[a("h3",{staticClass:"title"},[e._v("Reset Form")])]),e._v(" "),a("el-form-item",{attrs:{prop:"username"}},[a("span",{staticClass:"svg-container"},[a("svg-icon",{attrs:{"icon-class":"user"}})],1),e._v(" "),a("el-input",{ref:"username",attrs:{placeholder:"Username",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.ResetParam.username,callback:function(t){e.$set(e.ResetParam,"username",t)},expression:"ResetParam.username"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"nickname"}},[a("span",{staticClass:"svg-container"},[a("svg-icon",{attrs:{"icon-class":"user"}})],1),e._v(" "),a("el-input",{ref:"username",attrs:{placeholder:"Nickname",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.ResetParam.nickname,callback:function(t){e.$set(e.ResetParam,"nickname",t)},expression:"ResetParam.nickname"}})],1),e._v(" "),a("el-form-item",{attrs:{prop:"nickname"}},[a("span",{staticClass:"svg-container"},[a("svg-icon",{attrs:{"icon-class":"user"}})],1),e._v(" "),a("el-input",{ref:"username",attrs:{placeholder:"Email",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.ResetParam.email,callback:function(t){e.$set(e.ResetParam,"email",t)},expression:"ResetParam.email"}})],1),e._v(" "),a("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:e.loading,type:"primary"},nativeOn:{click:function(t){return t.preventDefault(),e.handleCommit(t)}}},[e._v("Commit")])],1)],1)},s=[],i=a("c24f"),r={name:"index",data:function(){return{ResetParam:{username:void 0,nickname:void 0,email:void 0},loading:!1}},methods:{handleCommit:function(){Object(i["a"])(this.ResetParam),this.$router.push({path:"/login"}),alert("请查收您的邮件")}}},o=r,c=(a("0031"),a("97fb"),a("623f")),l=Object(c["a"])(o,n,s,!1,null,"7f80c0b7",null);t["default"]=l.exports}}]);