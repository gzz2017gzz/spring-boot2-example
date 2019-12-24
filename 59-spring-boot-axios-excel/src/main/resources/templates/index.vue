<title>www.gaozz.com 中文乱码绝杀解决办法</title>
<script type="text/javascript" src="vue.min.js"></script>
<script type="text/javascript" src="axios.min.js"></script>
<div id="app">
    hearder中文乱码绝杀解决办法<br>
    <button @click="downfile">下载(axios)</button><br>
    <button @click="down">下载(浏览器)</button>
</div>
<script>
    new Vue({
        el: '#app',
        methods: {
            downfile() {
                axios({
                    method: 'post',
                    url: 'api/user/',
                    data: {},//可以带N多参数
                    responseType: 'arraybuffer',
                }).then(res => {
                    let link = document.createElement('a');
                    link.style.display = 'none';
                    link.href = window.URL.createObjectURL(new Blob([res.data], {type: "application/vnd.ms-excel"}));
                    link.download = decodeURI(res.headers['content-disposition'].split('=')[1]); // 划重点
                    document.body.appendChild(link);
                    link.click()
                    document.body.removeChild(link);
                });
            },
            down() {
            	location.href = "/api/role";
            },
        },
    });
</script>

 