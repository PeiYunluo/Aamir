(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4185e084"],{"31fb":function(t,e,i){"use strict";var n=i("beee"),s=i.n(n);s.a},"613f":function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"dashboard-container"},[i("div",{staticClass:"dashboard-text",attrs:{align:"center"}},[t._v("About ME")]),t._v(" "),i("br"),t._v(" "),i("br"),t._v(" "),i("br"),t._v(" "),i("el-row",[i("el-col",{attrs:{span:8,offset:4}},[i("div",{staticClass:"block"},[i("el-timeline",t._l(t.commits,(function(e,n){return i("el-timeline-item",{key:n,attrs:{timestamp:e.commit.committer.date}},[t._v("\n            "+t._s(e.commit.message)+"\n          ")])})),1)],1)]),t._v(" "),i("el-col",{attrs:{span:8}},[i("el-form",[i("br"),t._v(" "),i("br"),t._v(" "),i("span",[t._v("开发者邮箱：peiyunluo@icloud.com")]),t._v(" "),i("br"),t._v(" "),i("br"),t._v(" "),i("span",[t._v("GITHUB: https://github.com/PeiYunluo")]),t._v(" "),i("br"),t._v(" "),i("br"),t._v(" "),i("span",[t._v("后续会用freemaker引擎重构Aamir-blog-visitor")]),t._v(" "),i("br"),t._v(" "),i("br"),t._v(" "),i("span",[t._v("后续左侧会贴出项目commit记录现只是完成接口后续只需要改地址")])])],1)],1)],1)},s=[],r=i("b775");function a(){return Object(r["a"])({url:"https://api.github.com/repos/PeiYunluo/spider-scrapy/commits",method:"get"})}var o={name:"Dashboard",computed:{},data:function(){return{commits:[]}},created:function(){this.initCommits()},methods:{initCommits:function(){var t=this;a().then((function(e){t.commits=e.data}))}}},c=o,m=(i("31fb"),i("623f")),u=Object(m["a"])(c,n,s,!1,null,"44cb614e",null);e["default"]=u.exports},beee:function(t,e,i){}}]);