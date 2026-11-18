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
