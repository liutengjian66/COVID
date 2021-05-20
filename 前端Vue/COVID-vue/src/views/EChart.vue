<template>
<div>
<div id="Echart" style="width: 700px;height: 400px">
</div>
<div id="material" style="width: 700px;height: 400px">
</div>
</div>
</template>
<script>
import { color } from 'echarts';
export default {
    data(){
        return{
            LineVO:{
                month:'',
                status:{
                    type:'',
                    count:''
                }
            },
            PieVo:{
                name:'',
                value:''
            }
        }
    },
    mounted(){
            var echarts = require('echarts');
            var chartDom = document.getElementById('Echart');
            var machartDom=document.getElementById('material');
            var myChart = echarts.init(chartDom);
            var materialChart=echarts.init(machartDom);
        axios.get('http://localhost:8080/empiden/LineVO').then((resp)=>{
            this.LineVO.month=resp.data.month
            this.LineVO.status=resp.data.status
            console.log(this.LineVO.status)
            var option = {
    title: {
        text: '疫情趋势'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['隔离', '疑似', '确诊', '治愈', '死亡']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: this.LineVO.month//近期七个月
    },
    yAxis: {
        type: 'value',
        data:''
    },
    series: [
        {
            name: '隔离',
            type: 'line',
            data: this.LineVO.status.隔离
        },
        {
            name: '疑似',
            type: 'line',
            data: this.LineVO.status.疑似
        },
        {
            name: '确诊',
            type: 'line',
            data: this.LineVO.status.确诊
        },
        {
            name: '治愈',
            type: 'line',
            data: this.LineVO.status.治愈,
            color:"yellow"
        },
        {
            name: '死亡',
            type: 'line',
            data: this.LineVO.status.死亡,
            color:"black"
        }
    ]
};
myChart.setOption(option);
        });
        axios.get('http://localhost:8080/empiden/PieVO').then((resp)=>{
    this.PieVo=resp.data
    var option2= {
    tooltip: {
        trigger: 'item'
    },
    legend: {
        top: '5%',
        left: 'center'
    },
     title: {
        text: '物资情况'
    },
    series: [
        {
            name: '物资数量',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
                borderRadius: 10,
                borderColor: '#fff',
                borderWidth: 2
            },
            label: {
                show: false,
                position: 'center'
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '25',
                    fontWeight: 'bold'
                }
            },
            labelLine: {
                show: false
            },
            data: this.PieVo
        }
    ]
};
materialChart.setOption(option2);
})
    },
    methods:{
         
    }
}
</script>
