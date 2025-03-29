const inputs = document.querySelectorAll('.nbr');
const labels = document.querySelectorAll('.label');
const xc= document.getElementById("ess");
function on(){
const nbr= [];
const values = [];

// Boucler sur les éléments input et ajouter leurs valeurs au tableau
inputs.forEach(input => {
  values.push(parseFloat(input.value)); // Convertir les valeurs en nombres (si nécessaire)
});
labels.forEach(label=>{
    
    nbr.push(label.value); 
});
chartr(values,"bar");
function chartr(values, type) {
    
    new Chart(xc, {
        type: type, // ou 'bar', 'pie', etc.
        data: {
            labels:  nbr,
            datasets: [{
                    label: "nombre de chambre",
                    data: values,
                    backgroundColor: 'rgba(255, 26, 86, 0.5)',
                    borderColor: 'rgba(255, 26, 86, 0.8)',
                    borderWidth: 3,
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

}
on();