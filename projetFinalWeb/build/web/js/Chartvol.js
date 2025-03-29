
const cv = document.getElementById('charthvol').getContext('2d');
fetch('./data/vol.json')
        .then(function (response) {
            if (response.ok === true) {
                return response.json();
            }
        })
        .then(function (data) {
            creatChart(data, 'bar');
        });
        
function creatChart(data, type) {
    new Chart(cv, {
        type: type, // ou 'bar', 'pie', etc.
        data: {
            labels: data.map(row => row.nom_comp),
            datasets: [{
                    label: "nombre de billet d'avion",
                    data: data.map(row => row.nb_billet),
                    fill:true,
                    backgroundColor: 'rgba(255, 206, 86, 0.5)',
                    borderColor: 'rgba(255, 206, 86, 1)',
                    borderWidth: 3,
                    pointRadius: 5
                
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    responsive: true,
                    maintainAspectRation: false,
                }
            },
            animations: {
               
            }
        }
    });
}
;



