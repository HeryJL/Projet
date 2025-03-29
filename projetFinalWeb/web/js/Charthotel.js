function decont(id, limite) {
    let compteur = 0;
    const esp = (2000 / limite) - 10;
    const afficherCompteur = () => {
        document.getElementById(id).innerText = compteur;
        ;
    };

    const incrementer = () => {
        if (compteur < limite) {
            compteur++;
            afficherCompteur();
        } else {
            clearInterval(interval); // Arrête le compteur si la limite est atteinte
        }
    };
    const interval = setInterval(incrementer, esp);
    afficherCompteur();

}


function datax(x, y, bg) {
    const value = Regrouper(x, y);
    const datasets = Object.keys(value).map((values, index) => {
        return {
            label: values, // Nom de l'entreprise
            data: value[values], // Bénéfices correspondants
            // borderColor: colors[index].borderColor,  // Couleur de la bordure de la courbe
            borderColor: bg[index].replace('rgb', 'rgba').replace(')', `, 0.2)`).replace('0.2', '1'), // Couleur de fond (optionnel),  // Couleur de la bordure de la courbe
            // backgroundColor: colors[index].backgroundColor,  // Couleur de fond (optionnel)
            backgroundColor: bg[index].replace('rgb', 'rgba').replace(')', `, 0.2)`), // Couleur de fond (optionnel)
            fill: false, // Ne pas remplir sous la courbe
            tension: 0.4, // Courbure de la ligne
            borderWidth: 1
        };
    });
    return datasets;
}

function Regrouper(x, y) {
    var a = x.reduce((tab, value, index) => {
        if (!tab[value]) {
            tab[value] = [];  // Initialiser un tableau pour chaque entreprise
        }
        tab[value].push(y[index]);  // Ajouter le bénéfice correspondant
        return tab;
    }, {});
    return a;
}

function config(x, y, labels, backgroundColor) {
    const a = {
        type: "line", // ou 'bar', 'pie', etc.
        data: {
            labels: labels,
            datasets: datax(x, y, backgroundColor)
        },
        options: {
            scales: {
                x: {
                    title: {
                        display: true,
                        text: "Nombre d'item vendues' "
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Date'
                    }
                }
            }
        }

    };
    return a;
}

function line(i, x, y, bg) {
    var ctx = document.getElementById(i).getContext('2d');
    const rgbaColor = bg.replace('rgb', 'rgba').replace(')', `, 0.2)`)
    var a = new Chart(ctx, {
        type: 'line',
        data: {
            labels: x,
            datasets: [{
                    label: 'nombre de resrvation',
                    data: y,
                    borderColor: bg, // Couleur de fond (optionnel),  // Couleur de la bordure de la courbe
                    // backgroundColor: colors[index].backgroundColor,  // Couleur de fond (optionnel)
                    backgroundColor: rgbaColor, // Couleur de fond (optionnel)
                    borderWidth: 1,
                    pointRadius: 5,
                   
                    tension: 0.4,
                }]
        }

    });


}

function chart(i, values, type, labels, legende, backgroundColor) {
    const rgbaColor = backgroundColor.replace('rgb', 'rgba').replace(')', `, 0.2)`);
    const id = document.getElementById(i);
    var a = new Chart(id, {
        type: type, // ou 'bar', 'pie', etc.
        data: {
            labels: labels,
            datasets: [{
                    label: legende,
                    data: values,
                    backgroundColor: rgbaColor, // Couleur avec opacité
                    borderColor: rgbaColor.replace('0.2', '1'),
                    borderWidth: 1
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

            },
        }
    });
}

function MultipleBar(k, values, labels, legende, backgroundColor) {
    const id = document.getElementById(k);
    let dataSets = [];
    for (let i = 0; i < values.length; i++) {
        const rgbaColor = backgroundColor[i].replace('rgb', 'rgba').replace(')', `, 0.2)`);
        dataSets.push({
            label: legende[i],
            data: values[i],
            backgroundColor: rgbaColor, // Couleur avec opacité
            borderColor: rgbaColor.replace('0.2', '1'),
            borderWidth: 1,
        })

    }
    var a = new Chart(id, {
        type: 'bar', // ou 'bar', 'pie', etc.
        data: {
            labels: labels,
            datasets: dataSets
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
