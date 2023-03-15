const base = {
    get() {
        return {
            url : "http://localhost:8080/WebShop/",
            name: "WebShop",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/WebShop/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于javaweb的随心购商城"
        } 
    }
}
export default base
