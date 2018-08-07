Student Course Allocation

#Compilation
From the folder: ashish_kenjale_assign2\registrationScheduler\src

ant all
ant prepare

TO RUN:
From the folder: ashish_kenjale_assign2\registrationScheduler\src

ant run -Darg0=<reg-preference-file-name> -Darg0=<add-drop-file-name> -Darg1=<outputfilename> -Darg2=<number-of-threads> -Darg3=<logger level>

Example:
ant run -Darg0=reg-input.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=2 -Darg4=0

The files are read/written from/to here:
	ashish_kenjale_assign2/registrationScheduler/reg-input.txt
	ashish_kenjale_assign2/registrationScheduler/add-drop.txt
	ashish_kenjale_assign2/registrationScheduler/output.txt
will run 2 threads
will use Logger for debug level 0

CHOICE OF DATA STRUCTURE:
Data structure used is ConcurrentHashMap because the frequent operations are insert and this being a multithreaded project, ConcurrenthashMap is thread safe and hence multiple threads can insert to it at the same time and the time complexity for average case for get/put(lookup) is O(1) and is O(n) in the worst case and O(log n) for java 8 ConcurrentHashMap implementation. 


Citations:
NA

