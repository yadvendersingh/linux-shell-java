# POSIX Shell in Java

This project is a simple POSIX-like shell implemented in Java using design patterns. It supports basic shell commands such as `cd`, `pwd`, `echo`, `exit`, and `type`. The shell can also execute external programs found in the system's PATH.

## Features

### Built-in Commands:
- `cd [directory]`: Change the current directory.
- `pwd`: Print the current working directory.
- `echo [string ...]`: Print the provided arguments to the standard output.
- `exit`: Exit the shell.
- `type [command]`: Display information about the command.
- `clear`: Clears the shell screen.

### External Commands:
- Execute any external program available in the system's PATH.

## Design Patterns Used
- **Singleton Pattern**: Ensures a single instance of the `State` class.
- **Factory Pattern**: Used in `CommandRegistry` to create command instances.
- **Command Pattern**: Encapsulates commands as objects, allowing for flexible command execution.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven
- A terminal or command prompt

### Running the Shell

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. Compile the project:
    ```sh
    mvn package
    ```

3. Run the shell:
    ```sh
    ./run_shell.sh
    ```

## Usage

Once the shell is running, you can use the following commands:

- [cd [directory]]: Change the current directory.
- [pwd]: Print the current working directory.
- [echo [string ...]]: Print the provided arguments to the standard output.
- [exit]: Exit the shell.
- [type [command]]: Display information about the command.
- [clear]: Clear the shell screen.

You can also execute any external program available in the system's PATH and 'cd' command can handle relative as well as absolute paths.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

- Inspired by POSIX shell standards.