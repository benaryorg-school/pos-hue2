# GCJ Makefile

This is a simple Makefile script to compile a Java project using `gcj`.

## How To Use It

### Configuration

Just have your `.java` files in `src/` and then adjust the `config.mk` file.

### Building

To compile the program just run `make jar` to compile it to a _jar_ file named
`dist/main.jar` or run `make bin` to compile it to a binary at `dist/main`.

### Reusing the Repo

If you want to reuse this repo for a different project, just remove the
`src/.gitignore` file.

## License

WTFPL as specified in the `LICENSE` file.
