TOPDIR=$(shell pwd)

default:
	@echo "\033[32mgit clone https://github.com/fantasy-mark/demo.git\033[0m"
	@echo "\033[33mMark's demo!\033[0m"

install:
	@sudo cp $(TOPDIR)/www/* /var/www/ && \
		echo "\033[33mInstall successful!\033[0m"

push:
	git add .
	git config core.editor vim
	git commit -s
	git push -u origin master
