// script.js : petits comportements de l'interface de PolymathIA

// On attend que la page soit entièrement chargée avant d'agir
document.addEventListener("DOMContentLoaded", () => {

    // Zone de saisie du message (présente uniquement sur la page du chatbot)
    const zoneSaisie = document.querySelector(".pm-composer textarea");
    if (zoneSaisie === null) {
        return;
    }

    // 1. La zone de saisie s'agrandit quand on écrit plusieurs lignes (200 px maximum)
    zoneSaisie.addEventListener("input", () => {
        zoneSaisie.style.height = "auto";
        zoneSaisie.style.height = Math.min(zoneSaisie.scrollHeight, 200) + "px";
    });

    // 2. Un clic sur une suggestion copie son texte dans la zone de saisie
    document.querySelectorAll(".pm-suggestion").forEach((bouton) => {
        bouton.addEventListener("click", () => {
            zoneSaisie.value = bouton.textContent.trim();
            zoneSaisie.focus();
            zoneSaisie.dispatchEvent(new Event("input"));
        });
    });
});


// 3. Mise en forme Markdown des messages (Sprint 1, Séance 2, partie 14)
//    Solution retenue : marked (conversion) + DOMPurify (nettoyage contre les XSS)
document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".message-content").forEach((zone) => {
        // Lire le texte brut
        const texteBrut = zone.textContent;
        // Convertir le Markdown en HTML
        const html = marked.parse(texteBrut);
        // Assainir le HTML (retire les scripts et contenus dangereux)
        const htmlPropre = DOMPurify.sanitize(html);
        // Afficher le résultat
        zone.innerHTML = htmlPropre;
    });
});
