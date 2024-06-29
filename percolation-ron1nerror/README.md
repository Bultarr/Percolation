# Percolation Lab

In this lab, we examine one way of using the computer to simulate a problem
which can be solved only _probabilistically_, but not proved directly with
theoretical mathematics.

## Introduction

**Percolation Theory** is a field of mathematics related to network theory.
The problem of percolation is relatively simple. Give some material, is
there an open path within it through which water (or some other fluid) would
be able to flow.

There are many ways of considering this problem: in two vs. three dimmensions,
using square shapes vs. arbitrary shapes, etc. For our purposes, we will
consider an n-by-n square lattice or grid which contains individual sites,
which can be either open or closed. If a site is open, water can flow into
it. If it is closed, it cannot.

Now, water can flow from one site to another if and only if:

    1. The two sites share a common border and
    2. Both sites are open
    
Finally, we assume that water flows from _above_ the latice and can make its
way through open sites on the top row. We say that the system _percolates_ if
and only if water can flow in a complete path from somewhere in the top row to
an open site in the bottom row.

### Problem

Given a certain number of sites open in a lattice, there is a certain
probability _p_ that the system will percolate. The larger the system is, the
narrower that _p_ becomes. In other words, for large enough n-by-n systems, the
system will virtually always percolate when a certain fraction of open sites is
reached and virtually never percolate when that threshold fraction is not
reached.

This threshold can be determined by simmulation but it is not well understood
mathematically. That is, we can arrive at the solution computationally and
calculate the threshold with incredible precision, but we cannot prove it
to be correct _theoretically_. Thus, this problem showcases the strength of
computer programming as an empirical discipline which can make observations
quickly and cheaply.

### Monte Carlo Simulation

As we said above, the problem of finding the threshold at which our system will
percolate can presently only be solved probabilistically. We can do this rather
easily using what is called a _Monte Carlo Simulation_. A monte carlo
simulation relies on random values to determine an average or distribution for
some situation.

In our case, we will use this kind of simulation to create many percolation
systems and randomly open sites until each system percolates. Then we can
average the number of open sites to estimate the fraction of sites that need to
be opened for percolation to occur. This turns out to be a constant number, but
there is no mathematical proof, even though we can determine it experimentally!

## Assignment

In our study of dynamic connectivity, we created an algorithm using a tree data structure
to build a union-find algorithm. For this assignment, you will use your implementation of the
algorithm to write a class which can model the percolation system
as described above. To help, an interface called `Percolator` has been given
to specify the API for your class. This class should be called
`Percolation.java`. Your submission should also include the file `WeightedQuickUnion.java` containing
your UF code.

After you have correctly overriden the api for both classes, fill in the class `PercolationStats`. The
constructor for this class will run the monte carlo simulation. Specifically, it will generate multiple
percolation systems and randomly open sites until it percolates. It will then calculate the average
number of sites opened in each system (as well as the standard deviation).

Upload all three of these files to this repository.






