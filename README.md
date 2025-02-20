# Amazon Project BDD Framework

## Overview
This repository contains a configuration file used for application setup. It defines key properties required for accessing and managing system functionalities.

## Configuration Properties
The configuration file includes the following properties:

- **browser**: Specifies the browser type (e.g., Chrome, Firefox, Edge)
- **url**: Defines the target application URL
- **email**: Stores the email address for authentication
- **password**: Holds the login password (Ensure proper security measures)
- **pin**: A secondary authentication PIN

## Security Guidelines
- Do **not** commit sensitive information (such as passwords or PINs) directly to the repository.
- Use environment variables or encrypted storage for sensitive data.
- Consider adding a `.gitignore` entry to prevent accidental commits of configuration files containing credentials.

## Example Configuration File
```ini
browser=Chrome
url=https://example.com
email=user@example.com
password=your-secure-password
pin=1234
```

## Usage
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Update the configuration file with the required values.
3. Ensure credentials are secured before deployment.

## License
This project is licensed under the MIT License. See `LICENSE` for details.

