import React from 'react';
import { Navbar, Container, Nav, Button } from 'react-bootstrap';
import { BsFillPencilFill } from 'react-icons/bs';
import { FiShoppingBag } from 'react-icons/fi';
import { LinkContainer } from 'react-router-bootstrap';


const Header = () => {
  return (
    <Navbar bg="light" expand="lg" className="mb-3">
      <Container>
        <LinkContainer to="/">
          <Navbar.Brand className="d-flex align-items-center">
            <FiShoppingBag className="me-2" />
            <h1 className="h3">Shoppy</h1>
          </Navbar.Brand>
        </LinkContainer>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <LinkContainer to="/products">
              <Nav.Link>Products</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/carts">
              <Nav.Link>Carts</Nav.Link>
            </LinkContainer>
            <LinkContainer to="/products/new">
              <Nav.Link>
                <BsFillPencilFill />
              </Nav.Link>
            </LinkContainer>
            <Button variant="outline-primary" className="ms-2">Login</Button>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;