// Wait for the document to be fully loaded before running the script
document.addEventListener('DOMContentLoaded', () => {

    // Find the toggle button in the document
    const toggleButton = document.getElementById('mode-toggle');
    const buttonText = toggleButton.querySelector('.text');

    // Add a 'click' event listener to the button
    toggleButton.addEventListener('click', () => {
        
        // 1. Toggle the 'code-view' class on the <body>
        // This is what the CSS file uses to change all the styles
        document.body.classList.toggle('code-view');

        // 2. Check if the 'code-view' is now active
        if (document.body.classList.contains('code-view')) {
            // If yes, change the button text
            buttonText.textContent = 'View Canvas';
        } else {
            // If no, change it back to the default
            buttonText.textContent = 'View Code';
        }
    });

});