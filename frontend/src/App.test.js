import { render, screen } from '@testing-library/react';
import App from './App';
import About from './components/About'
import Footer from './components/Footer'

test('renders main page', () => {
    render(<App />);
    const linkElement = screen.getByText(/Pick a spot/i);
    expect(linkElement).toBeInTheDocument();
});

test('renders about page', () => {
    render(<About />);
    const linkElement = screen.getByText(/About the page/i);
    expect(linkElement).toBeInTheDocument();
});

test('renders footer page', () => {
    render(<Footer />);
    const linkElement = screen.getByText(/Copyright/i);
    expect(linkElement).toBeInTheDocument();
});
