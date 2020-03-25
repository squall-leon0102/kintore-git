var ctx = document.getElementById("myDoughnutChart").getContext('2d');
                                var myDoughnutChart = new Chart(ctx, {
                                    type: 'doughnut',
                                    data: {
                                           labels: ["腕立て伏せ","懸垂","サイドレイズ","腹筋","スクワット"],
                                           datasets: [{
                                                data: ["${training.pushup}","${training.kensui}","${training.sideraise}","${training.abs}","${training.squat}"],
                                                backgroundColor: [
                                                'rgba(255, 99, 132, 0.7)',
                                                'rgba(54, 162, 235, 0.7)',
                                                'rgba(255, 206, 86, 0.7)',
                                                'rgba(108, 204, 129, 0.7)',
                                                'rgba(153, 102, 255, 0.7)'
                                            ],
                                        }]
                                    },
                                    options: {
                                        responsive: true,
                                        legend: {
                                          position: 'right',
                                          labels :{
                                              fontsize: 20,
                                          }
                                        },
                                        }
                                        });