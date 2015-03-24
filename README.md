# GCJ Makefile

This is a simple Makefile script to compile a Java project using `gcj`.

## How To Use It

### Configuration

Just have your `.java` files in `src/` and then adjust the `config.mk` file.

### Building

To compile the program just run `make jar` to compile it to a _jar_ file named
`dist/main.jar` or run `make bin` to compile it to a binary at `dist/main`.

### External Resources

If you need some external _jar_ files, just put them into `res/`.

### Reusing the Repo

If you want to use this repo for a different project, just add it as a remote:

	$ cd your_project/
	$ mv src/ oldsrc/ # just to be sure
	$ git remote add gcj-makefile git://benary.org/benaryorg/gcj-makefile.git
	$ git pull gcj-makefile master
	$ mv oldsrc/* src/
	$ rmdir oldsrc/

## License

WTFPL as specified in the `LICENSE` file.
