var ctx = document.getElementById("myDoughnutChart").getContext('2d');
var myDoughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
           labels: ["腕立て伏せ","懸垂","サイドレイズ","腹筋","スクワット"],
           datasets: [{
                data: ["pushup","kensui","sideraise","abs","squat"],
                backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)'
            ],
        }]
    },

});